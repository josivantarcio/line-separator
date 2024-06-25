# Idioma Class

![Java](https://img.shields.io/badge/Java-8-red)
![GitHub](https://img.shields.io/badge/GitHub-josivantarcio%2Fline--separator-lightgrey)

## Overview

The `Idioma` class represents language settings with properties for English and Portuguese translations, along with file input and output paths. It facilitates language handling and file management within Java applications.

## Functionalities

- **Language Texts**: Stores and retrieves translations for English and Portuguese texts.
- **File Paths**: Manages paths for input (`caminhoEntrada`) and output (`caminhoSaida`) files.
- **Equality and Hashing**: Implements `equals()` and `hashCode()` methods for comparing objects based on all properties.

## Properties

- `english`: Stores English language text.
- `portugues`: Stores Portuguese language text.
- `caminhoEntrada`: Path for input files.
- `caminhoSaida`: Path for output files.

## Usage

### Example:

```java
Idioma idioma = new Idioma();
idioma.setEnglish("Hello");
idioma.setPortugues("Olá");
idioma.setCaminhoEntrada("/path/to/input.txt");
idioma.setCaminhoSaida("/path/to/output.txt");

System.out.println("English: " + idioma.getEnglish());
System.out.println("Portuguese: " + idioma.getPortugues());
System.out.println("Input Path: " + idioma.getCaminhoEntrada());
System.out.println("Output Path: " + idioma.getCaminhoSaida());
```

## Contact

For questions or feedback, please contact:

- **Jôsevan Tárcio Silva de Oliveira**
