# 📅 Reto Técnico SQA - DatePicker JQuery UI

## 📋 Descripción del Proyecto

Este proyecto contiene las pruebas automatizadas para validar la funcionalidad del componente DatePicker de JQuery UI, como parte del reto técnico para **SQA**. El objetivo es asegurar que el sistema de reservas permita seleccionar fechas correctamente sin errores.

## 🎯 Objetivo

Automatizar las pruebas del DatePicker para garantizar que los usuarios del módulo de reservas puedan seleccionar fechas de manera confiable desde el calendario emergente, validando tanto la funcionalidad básica como casos edge.

## 🔧 Tecnologías Utilizadas

* **Lenguaje**: Java 11+
* **Framework de Testing**: Serenity BDD 3.9.8
* **BDD Framework**: Cucumber 7.14.0
* **Testing Framework**: JUnit
* **Web Automation**: Selenium WebDriver 4.20.0
* **Build Tool**: Gradle
* **Patrón de Diseño**: Page Object Model (POM) + Step Definitions
* **Reporting**: Serenity Single Page HTML Report

## 📋 Configuración Gradle

### build.gradle

gradle

```gradle
plugins {
    id 'java'
    id 'net.serenity-bdd.serenity-gradle-plugin' version '3.9.8'
}

defaultTasks 'clean', 'test', 'aggregate'

repositories {
    mavenCentral()
}

dependencies {
    implementation 'net.serenity-bdd:serenity-core:3.9.8'
    implementation 'net.serenity-bdd:serenity-junit:3.9.8'
    implementation 'net.serenity-bdd:serenity-cucumber:3.9.8'
    implementation 'io.cucumber:cucumber-java:7.14.0'
    implementation 'io.cucumber:cucumber-junit:7.14.0'
    implementation 'org.seleniumhq.selenium:selenium-java:4.20.0'
}

test {
    testLogging.showStandardStreams = true
    systemProperties System.getProperties()
}

serenity {
    testRoot = "runners"
    requirementsBaseDir = "src/test/resources/features"
    reports = ["single-page-html"]
}

gradle.startParameter.continueOnFailure = true
test.finalizedBy(aggregate)
```

## 📁 Estructura del Proyecto

```
proyecto-datepicker-sqa/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── co.sqasa/
│   │           ├── pageObjects/
│   │           │   └── DatePickerPageObject.java
│   │           └── Steps/
│   │               └── DatePickerSteps.java
│   └── test/
│       └── java/
│           └── co.sqasa/
│               ├── helpers/
│               │   └── DateHelper.java
│               ├── runners/
│               │   └── TestRunner.java
│               └── StepDef/
│                   └── DatePickerStepDef.java
├── src/test/resources/
│   └── features/
│       └── Datepicker.feature
├── build/
│   └── reports/serenity/
├── build.gradle
├── gradle.properties
└── README.md
```

## 🧪 Casos de Prueba

### Feature: Seleccionar fecha en el DatePicker

**Como** usuario del módulo de reservas
**Quiero** seleccionar una fecha desde el calendario emergente "DatePicker"
**Para** poder agendar eventos en el sistema sin errores de fecha

### Escenarios de Prueba

#### Background

* **Given** que navego a la página principal de JQuery DatePicker
* **When** doy click en el campo de selección de fecha

#### CP-01: Reserva de una cita seleccionando una fecha en el calendario

* **And** selecciono el día 15 del mes actual
* **Then** la fecha seleccionada aparece en el campo de texto día 15

#### CP-02: Selección de una fecha específica en un mes diferente

* **And** navego hasta el próximo mes
* **And** selecciono el día 10 del próximo mes
* **Then** la fecha seleccionada aparece en el campo de texto del próximo mes día 10

#### CP-03: Validación de campo bloqueado

* **And** intento ingresar una fecha "20/08/2025" manualmente en el campo de texto
* **Then** valido que no se permite la edición manual y que solo es posible seleccionar una fecha desde el calendario

## 🚀 Instalación y Configuración

### Prerrequisitos

* **Java JDK 11** o superior
* **Gradle 7.0+** instalado
* **Google Chrome** (última versión)
* **ChromeDriver** (se descarga automáticamente via WebDriverManager)
* **IDE recomendado**: IntelliJ IDEA o Eclipse

### Pasos de Instalación

1. **Clonar el repositorio**

   bash

   ```bash
   git clone https://github.com/zagui-master/Reto_Tecnico_SQA.git
   cd Reto_Tecnico_SQA
   ```
2. **Verificar instalación de Gradle**

   bash

   ```bash
   gradle --version
   ```
3. **Construir el proyecto**

   bash

   ```bash
   gradle build
   ```
4. **Descargar dependencias**

   bash

   ```bash
   gradle dependencies
   ```
5. **Configurar Serenity**

   * El archivo `build.gradle` contiene toda la configuración
   * Los drivers se manejan automáticamente

## ▶️ Ejecución de Pruebas

### Ejecutar todas las pruebas

bash

```bash
gradle clean test aggregate
```

### Ejecutar solo las pruebas

bash

```bash
gradle test
```

### Ejecutar con tags específicos

bash

```bash
# Ejecutar caso específico
gradle test -Dcucumber.filter.tags="@CP-01"
```

### Generar solo el reporte

bash

```bash
gradle aggregate
```
