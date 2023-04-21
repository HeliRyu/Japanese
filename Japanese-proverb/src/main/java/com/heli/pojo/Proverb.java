package com.heli.pojo;

public class Proverb {
    // id 主键
    private Integer id;
    // 谚语日语
    private String proverb_name_jp_kanji;
    // 谚语假名
    private String proverb_name_jp_kana;
    // 描述信息
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProverb_name_jp_kanji() {
        return proverb_name_jp_kanji;
    }

    public void setProverb_name_jp_kanji(String proverb_name_jp_kanji) {
        this.proverb_name_jp_kanji = proverb_name_jp_kanji;
    }

    public String getProverb_name_jp_kana() {
        return proverb_name_jp_kana;
    }

    public void setProverb_name_jp_kana(String proverb_name_jp_kana) {
        this.proverb_name_jp_kana = proverb_name_jp_kana;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Proverb{" +
                "id=" + id +
                ", proverb_name_jp_kanji='" + proverb_name_jp_kanji + '\'' +
                ", proverb_name_jp_kana='" + proverb_name_jp_kana + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
