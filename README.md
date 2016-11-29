# jpa-orphan-removal-test ~~[DATAJPA-1013](https://jira.spring.io/browse/DATAJPA-1013)~~[HHH-9571](https://hibernate.atlassian.net/browse/HHH-9571)

# Reproduce

`./mvn clean test`

# What is the problem?

Entity `Movie` has a `@OneToMany(orphanRemoval=true)` relationship 
however when clearing the relationship (collection), and saving the `Movie` entity, `Character` objects are not deleted.
