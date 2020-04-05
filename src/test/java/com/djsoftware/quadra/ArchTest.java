package com.djsoftware.quadra;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.djsoftware.quadra");

        noClasses()
            .that()
                .resideInAnyPackage("com.djsoftware.quadra.service..")
            .or()
                .resideInAnyPackage("com.djsoftware.quadra.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.djsoftware.quadra.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
