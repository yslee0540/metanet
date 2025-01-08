package com.example.myapp.hr;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.myapp.hr.model.Emp;
import com.example.myapp.hr.service.IEmpService;

public class EmpMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");
		IEmpService empService = context.getBean(IEmpService.class);
		
		System.out.println("모든 사원의 수: " + empService.getEmpCount());
		System.out.println("50번 부서 사원의 수: " + empService.getEmpCount(50));
		
		System.out.println("--103번 사원 정보 조회");
		System.out.println(empService.getEmpInfoMap(103));
		System.out.println("--모든 사원 정보 조회");
		System.out.println(empService.getEmpListMap());
		
//		System.out.println("--새로운 사원 정보 입력");
//		Emp emp = new Emp();
//		emp.setEmployeeId(210);
//		emp.setFirstName("JinKyoung");
//		emp.setLastName("Heo");
//		emp.setEmail("HEOJK");
//		emp.setPhoneNumber("222-222");
//		emp.setHireDate(new java.sql.Date(System.currentTimeMillis()));
//		emp.setJobId("IT_PROG");
//		emp.setSalary(8000);
//		emp.setCommissionPct(0.2);
//		emp.setManagerId(100);
//		emp.setDepartmentId(10);
//		try {
//			empService.insertEmp(emp);
//			System.out.println("insert ok");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		System.out.println("--신규 사원 정보 조회");
//		Map<String, Object> emp210 = empService.getEmpInfoMap(210);
//		System.out.println(emp210);
//
//		Emp emp = new Emp();
//		emp.setEmployeeId(Integer.valueOf(emp210.get("employee_id").toString()));
//		emp.setFirstName(emp210.get("first_name").toString());
//		emp.setLastName(emp210.get("last_name").toString());
//		emp.setEmail(emp210.get("email").toString());
//		emp.setPhoneNumber(emp210.get("phone_number").toString());
//		emp.setHireDate(new java.sql.Date(System.currentTimeMillis()));
//		emp.setJobId(emp210.get("job_id").toString());
//		emp.setSalary(Double.valueOf(emp210.get("salary").toString()));
//		emp.setCommissionPct(Double.valueOf(emp210.get("commission_pct").toString()));
//		emp.setManagerId(Integer.valueOf(emp210.get("manager_id").toString()));
//		emp.setDepartmentId(Integer.valueOf(emp210.get("department_id").toString()));
//		
//		System.out.println("--210번 사원의 급여 10% 인상");
//		emp.setSalary(emp.getSalary() * 1.1);
//		empService.updateEmp(emp);
//		
//		System.out.println("--수정된 사원 정보 조회");
//		emp210 = empService.getEmpInfoMap(210);
//		System.out.println(emp210);
//	
		//트랜잭션 확인
		Emp emp = new Emp();
		emp.setEmployeeId(101);
		emp.setFirstName("Neena");
		emp.setLastName("Yang");
		emp.setEmail("NYANG");
		emp.setPhoneNumber("1.515.555.0101");
		emp.setHireDate(java.sql.Date.valueOf("2015-09-21"));
		emp.setJobId("FI_MGR");
		emp.setSalary(17000);
		emp.setCommissionPct(0);
		emp.setManagerId(100);
		emp.setDepartmentId(60);
		//empService.updateEmp(emp);
		
		//empService.deleteEmp(101, "NYANG");
		
//		System.out.println("--210번 사원 정보 삭제");
//		int rowCount = empService.deleteEmp(210, "HEOJK");
//		System.out.println(rowCount + "개 행이 삭제되었습니다.");
		
//		System.out.println("--모든 부서 번호와 부서 이름 정보");
//		System.out.println(empService.getAllDeptId());
//		System.out.println("--모든 직무 아이디와 직무 타이틀");
//		System.out.println(empService.getAllJobId());
//		System.out.println("--모든 매니저 번호와 매니저 이름");
//		System.out.println(empService.getAllManagerId());
		
//		System.out.println("--매퍼를 이용한 사원 정보 조회");
//		Emp searchEmp = empService.getEmpInfo(100);
//		System.out.println(searchEmp);
//		System.out.println(empService.getEmpList());
		
		context.close();
	}

}
