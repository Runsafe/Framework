### Contributing to Runsafe

We welcome any to contribute to any of the Runsafe projects including the Framework, Huckleberry and any underlying plug-ins for these systems. If you wish to do so, please make sure you follow the guidelines set below. There is a high chance we will not accept a pull request if it does not follow our guidelines.

* Our IDE of choice is IntelliJ. If you wish to use this, the project/inspection/library settings should be included with most projects.
* Changes to project files for personal preference should not be committed unless vital to the running of the project (library includes etc.).
* If you use another IDE, do not include any of the project settings with your commits.
* Please make sure there is an issue open in the correct project regarding the enhancement/bug-fix you are working on.
* All indents are TAB characters, not spaces.
* Braces for functions/methods/scopes start and end on a new-line (See Code Example A).
* A scope containing only one statement should not be surrounded by braces (See Code Example A).
* Ternary statements should be used but only where suiting.
* Inside a *switch*, if the *case* is more than one statement, the *case* and *break* should be on new lines (See Code Example B).
* Most of our projects support dependency injection through PicoContainer, this should be utilized where applicable.
* Normal String concatenation and the StringBuilder class are favored over String#format().
* No trailing whitespace.
* While a lot of our code lacks documentation, we expect any new methods or classes submitted to contain suiting documentation in JavaDoc format as we work toward full documentation.
* Make sure any changes you submit are tested properly!
* Your commit messages should be descriptive yet short.

#### Code Example A:
```java
public boolean canLockBlock(IBlock block)
{
    for (Item item : LockedObjectHandler.lockableItems)
        if (block.is(item))
            return true;

    return false;
}
```

#### Code Example B:
```java
switch (myValue)
{
    case 0: suchCase(); break;
    case 1: veryBreak(); break;
    case 2: wow(); break;
}

switch (myValue)
{
    case 0:
        if (isTrue)
        {
            suchCase();
            veryBreak();
        }
    break;
}
```