package com.amelielaurent38.digital.newsletter.listener;

import com.amelielaurent38.digital.newsletter.models.Article;

public interface ShareListener {
    void onShare(Article article);
    void onSelect(Article article);
    void onLike(Article article);
}
