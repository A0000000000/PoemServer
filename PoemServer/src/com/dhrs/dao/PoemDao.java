package com.dhrs.dao;

import com.dhrs.domain.Poem;

public interface PoemDao {

    Poem selectPoemByTitle(String title) throws Exception;

}
