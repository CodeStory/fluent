# Fluent

Java 8 Streams and Iterables on Steroids.

# Build status

[![Build Status](https://api.travis-ci.org/CodeStory/fluent.png)](https://travis-ci.org/CodeStory/fluent)

# Environment

- `java-1.8`

## Maven

Release versions are deployed on Maven Central:

```xml
<dependency>
  <groupId>net.code-story</groupId>
  <artifactId>fluent</artifactId>
  <version>1.4</version>
</dependency>
```

# Build

```bash
mvn clean verify
```

# Deploy on Maven Central

Build the release:

```bash
mvn release:clean release:prepare release:perform
```
