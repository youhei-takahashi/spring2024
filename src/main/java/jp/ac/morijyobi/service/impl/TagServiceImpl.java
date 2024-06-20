package jp.ac.morijyobi.service.impl;

import jp.ac.morijyobi.bean.entity.Tag;
import jp.ac.morijyobi.bean.form.TagForm;
import jp.ac.morijyobi.mapper.TagsMapper;
import jp.ac.morijyobi.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private final TagsMapper tagsMapper;

    public TagServiceImpl(TagsMapper tagsMapper) {
        this.tagsMapper = tagsMapper;
    }


    @Override
    public Tag registerTag(TagForm tagForm) {
        Tag tag = new Tag(-1, tagForm.getTagName());

        tagsMapper.insertTags(tag);

        return tag;
    }

    @Override
    public List<Tag> getAllTags() {
        return tagsMapper.selectAllTags();
    }
}
