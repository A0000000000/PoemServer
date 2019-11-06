package com.dhrs.dao.impl;

import com.dhrs.dao.PoemDao;
import com.dhrs.domain.Poem;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class PoemDaoImpl extends HibernateDaoSupport implements PoemDao {
    @Override
    public Poem selectPoemByTitle(String title) throws Exception {
        Poem poem = new Poem();
        poem.setPoemTitle(title);
        List<Poem> list = getHibernateTemplate().findByExample(poem);
        return list == null ? null : (list.size() > 0 ? list.get(0) : null);
    }
}
