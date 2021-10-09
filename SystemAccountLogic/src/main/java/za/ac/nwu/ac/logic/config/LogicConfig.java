package za.ac.nwu.ac.logic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ac.config.RepositoryConfig;

@Import({RepositoryConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.ac.logic.flow",
        "za.ac.nwu.ac.logic.flow.impl",
        "za.ac.nwu.ac.translator"
})
public class LogicConfig {
}