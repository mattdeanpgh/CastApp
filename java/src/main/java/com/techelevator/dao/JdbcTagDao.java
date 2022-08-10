package com.techelevator.dao;

import com.techelevator.model.Tag;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcTagDao implements TagDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTagDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Tag createTag(String tagName) {
        return null;
    }

    @Override
    public Tag updateTag(String tagName) {
        return null;
    }

    @Override
    public Tag deleteTag(String tagName) {
        return null;
    }

    @Override
    public List<Tag> getTagsForIssue(int issueId) {
        List<Tag> tag = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM tags JOIN tags_issue USING(tag_id) WHERE issue_id = ?;", issueId);
        while (results.next()){
            tag.add(mapRowToTag(results));
        }
        return tag;
    }

    private Tag mapRowToTag(SqlRowSet results) {
        Tag tag = new Tag();
        tag.getTagId(results.getInt("tag_id"));
        tag.getTagName(results.getString("tag_name"));
        return tag;

    }
}