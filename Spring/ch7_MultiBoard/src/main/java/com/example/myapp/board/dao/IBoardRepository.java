package com.example.myapp.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.myapp.board.model.Board;
import com.example.myapp.board.model.BoardUploadFile;

public interface IBoardRepository {
	List<Board> selectArticleListByCategory(@Param("categoryId") int categoryId, @Param("start") int start, @Param("end") int end);
	
	Board selectArticle(int boardId);
	void updateReadCount(int boardId);
	
	int selectMaxArticleNo();
	int selectMaxFileNo();
	void insertArticle(Board board);
	void insertFileData(BoardUploadFile file);
	BoardUploadFile getFile(int fileId);
	
	void updateReplyNumber(@Param("masterId") int masterId, @Param("replyNumber") int replyNumber);
	void replyArticle(Board board);
	
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
