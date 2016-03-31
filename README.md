# DocHeaderGenerator
Library to add some Header information to all the files. Typically can be used to add Copyright information to all the files.


## Motivation
Adding copyright information to all the source files of the project can be tedious if the project is large and can be cumbersome.
This library simplifies the task of writing the copyright information in just one file in the necessary format and running the library with the path to your project source code and it will append the information to all the specified files.
It will also show which are modified by the library and which are not so that you can keep a track of it.

## Usage
``` cmd
 java -jar docHeaderGenerator.jar <path_to_your_project_root> <path_to_header_file> <fileType> <fileType> ...
``` 
 Make sure JAVA_HOME is setup on your classpath to execute this.
 
#####Examples
``` cmd
 java -jar docHeaderGenerator.jar ./usr/vijet/projects/HelloWorld /usr/licenses/apache_license.txt *.* 
``` 
This modifies each of the files that are present in the *./usr/vijet/projects/HelloWorld* folder having any file extension.
``` cmd
 java -jar docHeaderGenerator.jar ./usr/vijet/projects/HelloWorld /usr/licenses/apache_license.txt *.java
``` 
This modifies all the .java files that are present in the *./usr/vijet/projects/HelloWorld* folder having any file extension.

``` cmd
 java -jar docHeaderGenerator.jar ./usr/vijet/projects/HelloWorld /usr/licenses/apache_license.txt *.java *.xml 
``` 
This modifies all the .java and .xml files that are present in the *./usr/vijet/projects/HelloWorld* folder having any file extension.


** NOTE:
* The first 3 arguments are mandatory(projectpath, header_file_path, file_format). Atleast one file format has to be specified.
* Its a good practice to keep a copy of your source code before using this library. If somethings goes wrong, its better to fallback to the earlier version.


USE THE LIBRARY AT YOUR OWN RISK, AND I AM NOT RESPONCIBLE FOR ANY LOSS, DAMAGE OF SOURCECODE USING THIS LIBRARY.
