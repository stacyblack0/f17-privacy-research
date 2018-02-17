# UserCentricPrivacy

A privacy management system for users.

## Description

This program allows the user to define rules to control how their information is shared. By default, no sharing is allowed, and each rule defines an instance in which information sharing is allowed. Each rule is made of several parts: the group to share information with, the type of information to share, and environmental and temporal (history) conditions that must be true in order for it to be shared.

This program also simulates sharing actions. The user can select a group and individual of that group to share some information with and the program will determine, based on the current environment and history of sharing, whether that action is valid.

Aside from the above, this program can also find and display rules matching a given individual and information type, and can display  the intersections where individuals are part of multiple groups (such as Family and Immediate Family).

## Getting Started

In order to run this program, clone the source files and copy them into the project directory for whatever IDE you are using. In IntelliJ, you will need to index the `.rar` libraries contained in `libs` (select `Project Structure...` and then `Project Settings > Libraries`, then click the green `+` button to add the two library folders, `libs` and `libs/solverlibs`).

If you receive the error `org.sosy_lab.common.configuration.InvalidConfigurationException: The SMT solver Z3 is not available on this machine because of missing libraries (no z3 in java.library.path). You may experiment with SMTInterpol by setting solver.solver=SMTInterpol.` you will need to add the files in `libs/solverlibs/path` to your classpath (in IntelliJ, the main directory for your project).
