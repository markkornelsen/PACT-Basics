# PACT Basic Repository

This repository demonstrates some basic PACT functionality.

## Provider
The provider project doesn't have any testing functionality built in.  It is simply a spring-boot service designed as follows:

Album -> Song

View the controller class for URL calling options.

## Consumer
The consumer project generates the pact file in PactGeneratorTests.java.  This can then be loaded into Pact-broker and compared to the response of the live running provider service.

The consumer project also contains PactConsumerControllerTests that demonstrate assertions against basic RestTemplate calls.  _The provider service must be running for these to pass._