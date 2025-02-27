package com.example.myapp.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.myapp.board.model.Board;
import com.example.myapp.board.model.BoardUploadFile;

@Repository
@Mapper
public interface IBoardRepository {
	List<Board> selectArticleListByCategory(@Param("categoryId") int categoryId, @Param("start") int start, @Param("end") int end);
	
	Board selectArticle(int boardId);
	void updateReadCount(int boardId);
	
	int selectMaxArticleNo();
	int selectMaxFileId();
	void insertArticle(Board board);
	void insertFileData(BoardUploadFile file);

	BoardUploadFile getFile(int fileId);

	void updateReplyNumber(@Param("masterId") int masterId, @Param("replyNumber") int replyNumber);
	void replyArticle(Board boardId);
	
	String getPassword(int boardId);
	void updateArticle(Board board);
	void updateFileData(BoardUploadFile file);

	Board selectDeleteArticle(int boardId);
	void deleteFileData(int boardId);
	void deleteArticleByBoardId(int boardId);
	
	void deleteReplyFileData(int boardId);
	void deleteArticleByMasterId(int boardId);
		
	int selectTotalArticleCount();
	int selectTotalArticleCountByCategoryId(int categoryId);

	int selectTotalArticleCountByKeyword(String keyword);
	
	List<Board> searchListByContentKeyword(@Param("keyword") String keyword, @Param("start") int start, @Param("end") int end);
}
