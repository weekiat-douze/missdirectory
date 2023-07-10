
<picture>
    <source srcset="docs/assets/images/MissDirectory_title_white.svg" media="(prefers-color-scheme: dark)">
    <img src="docs/assets/images/MissDirectory_title_black.svg">
</picture>

# Introduction

MissDirectory is a directory template manager used to automate the repetitive task of creating similar directory structures. MissDirectory embraces the power of command-line conventions to deliver a seamless editing experience for templates. It is designed to minimize the learning curve by building on familiar commands like 'cd' and 'mkdir'.
It encourages template reusability with its placeholder feature which allows users to specify directory name for each generation.

Visit the [User Guide](https://weekiat-douze.github.io/missdirectory/) page for features and detailed tutorial.

# Installation
### Basic
Ensure that you have Java 11 and above.
Download the jar file from the [release](https://github.com/weekiat-douze/missdirectory/releases/tag/v1.0) and place it in a directory
which serves as a home for MissDirectory. Run:
```
java -jar missdirectory.jar
```
### Recommended
We recommend to create an alias for MissDirectory so that it can be called from anywhere. By calling from the directory, you can use "current directory"
as the destination instead of specifying the path.
1. Follow the [Basic Installation](#basic)
2. Create an alias for MissDirectory <br>e.g. `alias missdirectory="java -jar /path/to/jar/file/missdirectory.jar"`
3. Restart shell to apply alias
4. Use the alias e.g. `missdirectory` or `missdirectory -g`

> **Quick Generation `-g`**<br>
> MissDirectory accepts an optional flag `-g`.
When passed, MissDirectory will go into [Generate Mode](https://weekiat-douze.github.io/missdirectory/#generate-mode) directly to enable quick directory generation.

# Demo




