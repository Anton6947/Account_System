package za.ac.nwu.ac.translator.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import za.ac.nwu.ac.config.RepositoryConfig;
import org.springframework.context.annotation.Import;

@Import({RepositoryConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.ac.translator"
})
public class TranslatorConfig {
}
