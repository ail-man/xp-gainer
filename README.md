## Automatic XP gaining project for Duolingo
### Parameters
With Chrome Driver it doesn't work. So, use Firefox Gecko Driver, using JVM params:
```
-Dselenide.browser=firefox -Dduolingo.username=<your_login> -Dduolingo.password=<your_password>
```
To update the dictionary "on the fly", need to use `Pairs.readFromFile()` instead of `readFromFileResource()`

In case of failed test, reports with screenshots will be generated in the `build/reports/tests` folder.
