# Selenium - Web Automation Framework
Test automation framework for web applications using Selenium 4 and Java

![WebDriver-W3C-Protocol-1](https://user-images.githubusercontent.com/48508827/155773516-432123c9-a3fe-40d0-8c95-1aaea1c7ec91.png)

## Docker commands

### To Run Elasticsearch
```
docker run -p 9200:9200 -p 9300:9300 --name elasticsearch -e "discovery.type=single-node"  docker.elastic.co/elasticsearch/elasticsearch:7.11.1
```

### To Run Kibana
```
docker run -p 5601:5601 --name kibana --link elasticsearch:elasticsearch docker.elastic.co/kibana/kibana:7.11.1
```