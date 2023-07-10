---
layout: default
---

<img src="assets/images/MissDirectory_title_black.svg">


MissDirectory is a directory template manager used to automate the repetitive task of creating similar directory structures. MissDirectory embraces the power of command-line conventions to deliver a seamless editing experience for templates. It is designed to minimize the learning curve by building on familiar commands like 'cd' and 'mkdir'.
It encourages template reusability with its placeholder feature which allows users to specify directory name for each generation.

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
2. Create an alias for MissDirectory e.g. `alias missdirectory="java -jar /path/to/jar/file/missdirectory.jar"`
3. Restart shell to apply alias
4. Use the alias e.g. `missdirectory` or `missdirectory -g`

> **Quick Generation `-g`**<br>
> MissDirectory accepts an optional flag `-g`.
When passed,MissDirectory will go into [Generate Mode](#generate-mode) directly to enable quick directory generation. 

# Main Menu
When you start the Application, MissDirectory will ask you to choose the action you would like to perform. By selecting an action, you will enter one of the following modes:

| Views                           | Option           | Description                                                         |
|---------------------------------|------------------|---------------------------------------------------------------------|
| [Editor Mode](#editor-mode)     | 2 / Create       | A command-line inspired editor mode for template manipulation.      |  
| [View Mode](#view-mode)         | 1 / View, Modify | Provides an overview of templates as well as actions to manage them |
| [Generate Mode](#generate-mode) | 3 / Generate     | Creates the directory structure from an existing template           |

```
What would you like to do today?
1. View/Modify Directory Templates
2. Create New Template
3. Generate Directory Structure
4. quit
> 
```

> To exit the Application from Main Menu, input `4` or `quit`


## Editor Mode
A command-line inspired editor mode for template manipulation. It is designed to minimize the learning curve by building on familiar commands like 'cd' and 'mkdir'.
Like the terminal, the prompt also shows the current directory.

| Commands                   | Description                                        |
|----------------------------|----------------------------------------------------|
| `cd [ SUBDIRECTORY / .. ]` | Change directory to sub, parent, or root directory |
| `ls`                       | see the subdirectories of current directory        |
| `mkdir NAME`               | create a directory in current directory            |
| `rm SUBDIRECTORY`          | delete a subdirectory of current directory         |
| `tree`                     | see template's structure in tree form              |
| `exit`                     | save and exit template editor                      |
| `help`                     | see summary of commands in Editor Mode             |

> Note that the template is only saved when you `exit` the Editor Mode. Changes will be lost if you abruptly close MissDirectory.

Tree Structure Example:
```
(Course) @/
  ├─ lecture_note/
  │    ├─ lecture_2/
  │    ├─ lecture_1/
  ├─ tutorial/
  ├─ assignment/
```
### Placeholder Feature
Templates are rooted under a single directory with the placeholder (@). During generation of directory, there will be a prompt to give a name to replace the placeholder. The character "@" if used in the subdirectories will be replaced with the provided name.
```
(Course) @/                           (Course) CS1101S/
  ├─ lecture_note/            \          ├─ lecture_note/          
  │    ├─ lecture_2/      ---- \         │    ├─ lecture_2/
  │    ├─ lecture_1/      ---- /         │    ├─ lecture_1/
  ├─ @_tutorial/              /          ├─ CS1101S_tutorial/
  ├─ @_assignment/                       ├─ CS1101S_assignment/
```

## View Mode
A template manager that provides an overview of templates and accompanying actions to manage them.

| Commands       | Description                                    |
|----------------|------------------------------------------------|
| `tree INDEX`   | see template's structure in tree form          |
| `delete INDEX` | delete a template                              |
| `edit INDEX`   | edit a template in [Editor Mode](#editor-mode) |
| `exit`         | return to Main Menu                            |
| `help`         | see summary of commands in View Mode           |

```
[edit | delete | tree] {index}
1. Course
2. Project
3. Photos
> 
```

## Generate Mode
Sequence of prompts to finalize details of the directory to be generated.
1. Choose template
2. Choose name for root directory and [placeholder](#placeholder-feature) (@)
3. Destination

> To leave Generate Mode, simply enter `exit` during any of the above prompts

### Choosing Templates
```
Which template should I use?
1. Course
2. Project
3. Photos
>
```
The first prompt will list all templates and selection is done using the index.

### Name for Root & Placeholder
```
What should root directory & placeholders(@) be called? > 
```
The name provided here will be used for the root directory as well as any "@" characters in the subdirectories. Therefore, only valid directory names are allowed here.
1. Must be valid directory names (no illegal characters)
2. Placeholder cannot result in multiple directories with the same name in the same directory

### Destination
```
Where should the folder be placed?(enter to create in current directory)
> 
```
Provide a path to tell MissDirectory where the template should be generated in.
You can press enter if you would like to create it in the current directory

