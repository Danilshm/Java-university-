# Information extraction 
- IE refers to the natural language processing(NLP) task of extracting relevant information from text
- IE can be a challenge with unstructured data
## Digital assistant
- <font color="#ff0000">Where</font> is the <font color="#9bbb59">nearest</font> <font color="#4bacc6">coffee shop</font>? 
	- Where = need address
	- nearest = current location
	- coffee shop = 
## Types of IE
- Key phrase extraction(KPE)
- Named entity recognition
- Named entity disambiguation(NED)
- Event extraction
- Relationship extraction
### KPE(Key phrase extraction)
- KPE extracts useful words and phrases from text to capture the general intent 
- KPE is generally unsupervised learning [[Supervised and Unsupervised Learning#Unsupervised|Unsupervised]]
- Words are nodes in a weighted graph
	- Weight indicates the importance of a key-phrase
- Amazon Comprehed pro
### Named entity recognition(NER)
- NER is the NLP task of identifying entites such as names, locations, organization.
- Amazon Comprehend provides API actions for entity recognition to find insights and relationships in text
- Example:
	- Alexa, where was Bob born?
### Named entity disambiguation (NED)
- NED is the NLP task of uniquely identifying entities in the text
- NER and NED enable named entity linking(NEL)
### Event extraction 
- EE is the process of identifying and extracting knowledge about events in text data.
## IE with Amazon Comprehead 
- Amazon Comprehead uses pretrained models to do the following. 
- Detect entities and e.t.c.