package jp.ac.morijyobi.service;

import jp.ac.morijyobi.bean.entity.Tag;
import jp.ac.morijyobi.bean.form.TagForm;

import java.util.List;

public interface TagService {

    Tag registerTag(TagForm tagForm);

    List<Tag> getAllTags();
}
