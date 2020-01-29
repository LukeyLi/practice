package com.lzy.design.pattern.behavioral.templatemethod;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 18:24
 **/
public class FECourse extends ACourse {
    private boolean needWriteArticleFlag = false;
    @Override
    void packageCourse() {
        System.out.println("提供课程的前端代码");
        System.out.println("提供课程的图片等多媒体素材");
    }

    public FECourse(boolean needWriteArticleFlag) {
        this.needWriteArticleFlag = needWriteArticleFlag;
    }

    @Override
    protected boolean needWriteArticle() {
        return this.needWriteArticleFlag;
    }
}
