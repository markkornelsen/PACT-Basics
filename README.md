# PACT Basic Repository

This repository demonstrates some basic PACT functionality.

## Provider
The provider project doesn't have any testing functionality built in.  It is simply a spring-boot service designed as follows:

Album -> Song

View the controller class for URL calling options.

## Consumer
The consumer project generates the pact file in PactGeneratorTests.java.  This can then be loaded into Pact-broker and compared to the response of the live running provider service.

The consumer project also contains PactConsumerControllerTests that demonstrate assertions against basic RestTemplate calls.  _The provider service must be running for these to pass._



## Pact-broker setup steps (Windows)

1. Install Ruby 2.3.3 (not the latest version)
2. update ruby gems 
```
gem update --system 2.3.0
```
3. install ruby certificate
	-copy certificate from [rubygems site](http://guides.rubygems.org/ssl-certificate-update/#manual-solution-to-ssl-issue)
	- into..
	- [Ruby Install Directory]\lib\ruby\site_ruby\2.3.0\rubygems\ssl_certs
4. download, extract, and install [Ruby DevKit](https://rubyinstaller.org/downloads/)
	- cd into the devkit extracted folder
	- run the following commands:
	 
```shell
ruby dk.rb init
ruby dk.rb install
```
5. clone pact_broker from [github](https://github.com/bethesque/pact_broker)
6. cd into pact_broker/example
6. install bundler 
```shell
gem install bundler
```
6. run bundle (this downloads remaining packages into the directory)
```shell
bundle install
```
6. start the broker (runs the pact-broker on localhost/port#)
```shell
bundle exec rackup -p 8080
```
6. to view browser, browse to that port #
	<http://localhost:8080>
6. update pom: <pactBrokerUrl>http://localhost:8080</pactBrokerUrl> to match the port #
6. Change <pactDirectory>pacts</pactDirectory> to the folder where the pact gets generated into (/target/pact or whatever)
6. Change <pactDirectory>pacts</pactDirectory> to the folder where the pact gets generated into (/target/pact or whatever)

**Additional Steps:**

To publish the consumer pact: 
```
mvn pact:publish
```

To compare the consumer pact to the provider response: 
```
mvn pact:verify
```

