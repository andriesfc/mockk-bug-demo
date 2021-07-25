# MockK Bug/Issue Demo

When running unit test, the following unwanted response are dumped on the **STDERR** stream:

```shell
./gradlew test
> Task :test
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by io.mockk.InternalPlatformDsl (file:/Users/andriesfc/.gradle/caches/modules-2/files-2.1/io.mockk/mockk-dsl-jvm/1.12.0/eb517db1a4dea71a3bdce5065b3b280b559ff958/mockk-dsl-jvm-1.12.0.jar) to field java.io.BufferedReader.in
WARNING: Please consider reporting this to the maintainers of io.mockk.InternalPlatformDsl
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
```

