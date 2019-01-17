package com.arkadiusz.migala.simplecrud.data;

import com.arkadiusz.migala.simplecrud.model.ArticleRead;
import com.arkadiusz.migala.simplecrud.model.ArticleUpdate;
import com.arkadiusz.migala.simplecrud.model.ArticleWrite;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleRepository {

    @Select("SELECT * FROM article WHERE id = #{id}")
    List<ArticleRead> findById(Long id);

    @Select("SELECT * FROM article WHERE title = #{title}")
    List<ArticleRead> findByTitle(String title);

    @Select("SELECT * FROM article")
    List<ArticleRead> findAll();

    @Insert("INSERT INTO article(title, content) VALUES (#{title}, #{content})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void insert(ArticleWrite article);

    @Update("UPDATE article SET article.content = #{content} WHERE article.id = #{id}")
    void updateContent(ArticleUpdate article);

    @Delete("DELETE FROM article WHERE id = #{id}")
    void delete(Long id);
}
