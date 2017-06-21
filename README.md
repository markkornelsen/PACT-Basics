# PACT Basic Repository

This repository demonstrates some basic PACT functionality.

## Provider
The provider project doesn't have any testing functionality built in.  It is simply a spring-boot service designed as follows:

Album -> Song

View the controller class for URL calling options.

## Consumer
The consumer project generates the pact file in PactGeneratorTests.java.  This can then be loaded into Pact-broker and compared to the response of the live running provider service.

The consumer project also contains PactConsumerControllerTests that demonstrate assertions against basic RestTemplate calls.  _The provider service must be running for these to pass._



## Pact-broker setup steps

1. Xinstall ruby bundler
2. Xclone https://github.com/bethesque/pact_broker
3. cd into pact_broker/example
4. run bundle (this will prompt for password and install )
5. run bundle exec rackup -p xportnumber(8080 or whatever)- this starts the broker
6. to view browser, browse to that port #
7. update pom: <pactBrokerUrl>http://localhost:8080</pactBrokerUrl> to match the port #

consumer: run pact:publish
provider: run pact:verify


change <pactDirectory>pacts</pactDirectory> to the folder where the pact gets generated into (/target/pact or whatever)
