package com.shijihui.config;

import freemarker.cache.TemplateLoader;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.List;

/**
 * Created by jiangzhiyong on 15/12/8.
 */
public class HtmlFreeMarkerConfigurer extends FreeMarkerConfigurer {

    @Override
    protected TemplateLoader getAggregateTemplateLoader(List<TemplateLoader> templateLoaders) {
        TemplateLoader aggregateTemplateLoader = super.getAggregateTemplateLoader(templateLoaders);
        HtmlTemplateLoader htmlTemplateLoader = new HtmlTemplateLoader(aggregateTemplateLoader);
        return htmlTemplateLoader;
    }
}
