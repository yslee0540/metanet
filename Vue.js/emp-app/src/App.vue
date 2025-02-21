<template>
  <div class="container">
    <h1>Employees Management</h1>
    <button @click="openModal(false)" class="add-employee-button">Add new Employee</button>

    <!-- 리스트 -->
    <h2>Employee List</h2>
    <table>
      <thead>
        <tr>
          <th>Employee ID</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Phone Number</th>
          <th>Job ID</th>
          <th>Hire Date</th>
          <th>Salary</th>
          <th>Commission Pct</th>
          <th>Manager ID</th>
          <th>Department ID</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="employee in paginatedEmployees" :key="employee.employeeId">
          <td>{{ employee.employeeId }}</td>
          <td>{{ employee.firstName }}</td>
          <td>{{ employee.lastName }}</td>
          <td>{{ employee.email }}</td>
          <td>{{ employee.phoneNumber }}</td>
          <td>{{ employee.jobId }}</td>
          <td>{{ employee.hireDate }}</td>
          <td>{{ employee.salary }}</td>
          <td>{{ employee.commissionPct }}</td>
          <td>{{ employee.managerId }}</td>
          <td>{{ employee.departmentId }}</td>
          <td>
            <button @click="openModal(true, employee)">Edit</button>
            <button @click="promptDelete(employee.employeeId, employee.email)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
    
    <!-- 모달 -->
    <div v-if="isModalVisible" class="modal">
      <div class="modal-content">
        <h2>{{ isEditing ? 'Edit Employee' : 'Add New Employee' }}</h2>
        <form @submit.prevent="handleSubmit">
          <div class="form-group">
            <label for="employeeId">Employee ID:</label>
            <input v-model="currentEmployee.employeeId" type="text" id="employeeId" :disabled="isEditing" required />
          </div>
          <div class="form-group">
            <label for="firstName">First Name:</label>
            <input v-model="currentEmployee.firstName" type="text" id="firstName" required/>
          </div>
          <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input v-model="currentEmployee.lastName" type="text" id="lastName" required/>
          </div>
          <div class="form-group">
            <label for="email">Email:</label>
            <input v-model="currentEmployee.email" type="text" id="email" required/>
          </div>
          <div class="form-group">
            <label for="phoneNumber">Phone Number:</label>
            <input v-model="currentEmployee.phoneNumber" type="text" id="phoneNumber" required/>
          </div>
          <div class="form-group">
            <label for="jobId">Job ID:</label>
            <div v-if="jobs.length">
              <select v-model="currentEmployee.jobId" id="jobId" required>
                <option value="" disabled>선택하세요.</option>
                <option v-for="job in jobs" :key="job.jobId" :value="job.jobId">
                  {{ job.jobTitle }}
                </option>
              </select>
            </div>
            <div v-else>
              <select disabled>
                <option>No jobs available</option>
              </select>
            </div>
          </div>
          <div class="form-group">
            <label for="hireDate">Hire Date:</label>
            <input v-model="currentEmployee.hireDate" type="date" id="hireDate" required/>
          </div>
          <div class="form-group">
            <label for="salary">Salary:</label>
            <input v-model="currentEmployee.salary" type="number" id="salary" required/>
          </div>
          <div class="form-group">
            <label for="commissionPct">Commission Pct:</label>
            <input v-model="currentEmployee.commissionPct" type="number" id="commissionPct" />
          </div>
          <div class="form-group">
            <label for="managerId">Manager ID:</label>
            <select v-model="currentEmployee.managerId" id="managerId">
              <option value="" disabled>선택하세요.</option>
              <option v-for="manager in managers" :key="manager.managerId" :value="manager.managerId">
                {{ manager.managerName }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label for="departmentId">Department:</label>
            <select v-model="currentEmployee.departmentId" id="departmentId" required>
              <option value="" disabled>선택하세요.</option>
              <option v-for="department in departments" :key="department.departmentId" :value="department.departmentId">
                {{ department.departmentName }}
              </option>
            </select>
          </div>
          <div class="modal-actions">
            <button type="submit" class="btn-primary">{{ isEditing ? 'Save Changes' : 'Add Employee' }}</button>
            <button type="button" @click="closeModal" class="btn-secondary">Cancel</button>
          </div>
        </form>
      </div>
    </div>

    <!-- 페이징 -->
    <div class="pagination-controls">
      <button :disabled="currentPage === 1" @click="currentPage--">Previous</button>
      <span>Page {{ currentPage }} of {{ totalPages }}</span>
      <button :disabled="currentPage === totalPages" @click="currentPage++">Next</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      employees: [],
      departments: [],
      jobs: [],
      managers: [],
      currentEmployee: {},
      isEditing: false,
      isModalVisible: false,
      currentPage: 1,
      itemsPerPage: 10,
    };
  },
  computed: {
    totalPages() {
      return Math.ceil(this.employees.length / this.itemsPerPage);
    },
    paginatedEmployees() {
      const start = (this.currentPage - 1) * this.itemsPerPage;
      const end = start + this.itemsPerPage;
      return this.employees.slice(start, end);
    }
  },
  methods: {
    getDefaultEmployee() {
      return {
        employeeId: '',
        firstName: '',
        lastName: '',
        email: '',
        phoneNumber: '',
        jobId: '',
        hireDate: '',
        salary: null,
        commissionPct: null,
        managerId: '',
        departmentId: ''
      };
    },
    async fetchData(endpoint, targetProperty) {
      try {
        const response = await axios.get(endpoint);
        this[targetProperty] = response.data;
      } catch (error) {
        console.error(`Error fetching data from ${endpoint}:`, error);
      }
    },
    handleSubmit() {
      if (this.isEditing) {
        this.updateEmployee();
      } else {
        this.addEmployee();
      }
    },
    async addEmployee() {
      try {
        const response = await axios.post('http://192.168.0.4:8081/api/employees', this.currentEmployee);
        this.employees.push(response.data);
        this.closeModal();
      } catch (error) {
        console.error('Error adding employee:', error);
      }
    },
    async updateEmployee() {
      try {
        await axios.put(`http://192.168.0.4:8081/api/employees`, this.currentEmployee);
        const index = this.employees.findIndex(e => e.employeeId === this.currentEmployee.employeeId);
        this.employees.splice(index, 1, this.currentEmployee);
        this.closeModal();
      } catch (error) {
        console.error('Error updating employee:', error);
      }
    },
    openModal(editing = false, employee = null) {
      this.isEditing = editing;
      this.currentEmployee = editing ? { ...employee } : this.getDefaultEmployee();
      this.isModalVisible = true;
    },
    closeModal() {
      this.isModalVisible = false;
      this.currentEmployee = {};
    },
    async promptDelete(employeeId, email) {
      const userInput = prompt('삭제할 사원의 이메일을 입력하세요.:');
      if (userInput && userInput === email) {
        try {
          await axios.delete(`http://192.168.0.4:8081/api/employees?empid=${employeeId}&email=${email}`);
          this.employees = this.employees.filter(e => e.employeeId !== employeeId);
          alert('Employee successfully deleted.');
        } catch (error) {
          console.error('Error deleting employee:', error);
        }
      } else {
        alert('Email does not match. Deletion canceled.');
      }
    },
  },
  mounted() {
    this.fetchData('http://192.168.0.4:8081/api/employees', 'employees');
    this.fetchData('http://192.168.0.4:8081/api/employees/jobids', 'jobs');
    this.fetchData('http://192.168.0.4:8081/api/employees/mgrids', 'managers');
    this.fetchData('http://192.168.0.4:8081/api/employees/deptids', 'departments');
  }
};
</script>

<style scoped>
.container {
  max-width: 1000px;
  margin: auto;
  padding: 20px;
}

.add-employee-button {
  margin-bottom: 20px;
  padding: 10px 15px;
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.add-employee-button:hover {
  background-color: #45a049;
}

.modal {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background: white;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
  z-index: 1000;
  width: 90%;
  max-width: 500px;
}

.modal-content {
  display: flex;
  flex-direction: column;
  gap: 15px;
}

.form-group {
  display: flex;
  flex-direction: column;
  margin-bottom: 15px;
}

label {
  margin-bottom: 5px;
  font-weight: bold;
}

input, select {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.modal-actions {
  display: flex;
  justify-content: flex-end;
  gap: 10px;
}

.btn-primary {
  padding: 10px 15px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.btn-primary:hover {
  background-color: #0056b3;
}

.btn-secondary {
  padding: 10px 15px;
  background-color: #6c757d;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.btn-secondary:hover {
  background-color: #5a6268;
}

.pagination-controls {
  margin-top: 20px;
  text-align: center;
}

.pagination-controls button {
  margin: 0 5px;
  padding: 5px 10px;
}
</style>
