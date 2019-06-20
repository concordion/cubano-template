package org.concordion.cubano.template.framework;

import org.concordion.api.ConcordionResources;
import org.concordion.api.FailFast;
import org.concordion.api.extension.Extensions;
import org.concordion.cubano.framework.ConcordionFixture;
import org.concordion.cubano.template.AppConfig;
import org.concordion.cubano.template.driver.httpeasy.HttpEasyConfigurator;
import org.concordion.ext.TimestampFormatterExtension;
import org.concordion.ext.runtotals.RunTotalsExtension;
import org.concordion.ext.statusinfo.StatusInfoExtension;
import org.concordion.slf4j.ext.ReportLogger;
import org.concordion.slf4j.ext.ReportLoggerFactory;

/**
 * A base class for extension by fixtures that contain assertions.
 *
 * @see CubanoTemplateIndex for fixtures that don't contain assertions
 * @see CubanoTemplateBrowserFixture for fixtures that invoke a browser
 */
@ConcordionResources("/customConcordion.css")
@Extensions({ TimestampFormatterExtension.class, RunTotalsExtension.class, StatusInfoExtension.class })
@FailFast
public abstract class CubanoTemplateFixture extends ConcordionFixture {
    protected final ReportLogger reportLogger = ReportLoggerFactory.getReportLogger(this.getClass().getName());

    static {
        AppConfig.getInstance().logSettings();

        HttpEasyConfigurator.applyDefaultSettings();
    }

    /** Override the default logger. **/
    public CubanoTemplateFixture() {
        super.withFixtureListener(new CubanoTemplateFixtureLogger());
    }
}
