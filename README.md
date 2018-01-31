----
## Extended Shared Library
see [Jenkins.io](https://jenkins.io/doc/book/pipeline/shared-libraries/)

> Pipeline has support for creating "Shared Libraries" which can be defined in external source control repositories and loaded into existing Pipelines.

    (root)
    +- src                     # Groovy source files
    |   +- org
    |       +- k9
    |           +- scm
    |           	+- Git.groovy
    +- resources               # resource files (external libraries only)
    |   +- org
    |       +- k9
    |           +- docker
    |           	+- maven   # Based on environment name
