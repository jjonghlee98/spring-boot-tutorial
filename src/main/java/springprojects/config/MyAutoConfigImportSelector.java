package springprojects.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class MyAutoConfigImportSelector implements ImportSelector {
    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> autoConfig = new ArrayList<>();

        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfig::add);

        return autoConfig.toArray(String[]::new);

//        Iterable<String> candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);
//        return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);
//
//        List<String> autoConfigs = new ArrayList<>();
//
//        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfigs::add);
//
//        return autoConfigs.toArray(new String[0]);
    }
}
