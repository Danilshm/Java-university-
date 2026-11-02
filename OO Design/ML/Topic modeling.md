# Topic modeling 
- finding topics in a large collection of documents
- is an unsupervised machine learning model that scans a set of documents to detect word and phrase pattern
## Topic modeling use cases
- Document classification 
- Automatic content tagging 
- Document summarization 
- Information retrieval by using topics 
- Content recommendation based on topics 
# Processing steps
- Clean the data 
- Remove stopwords
- Lemmatize the data
- Vectorize or tokenize the document 

# Latent Drichlet Allocation(LDA)
- Unsupervised learning algorithm
- Describes a set of documents as a mixture of distinct topis
- Topics are not specified up front 
- Might not align with how a human would categorize
- Word groups = topics
# Hyperparameters 
- are external configuration settings that you define before training a machine learning model to control how the learning process work
# Perplexity and coherence
## Perplexity (Uncertainty and Prediction)
- **Definition:** Measures how "surprised" a language model is by new, unseen data. Mathematically, it is the exponential of the average negative log-likelihood of a test set.
## Coherence (Semantic Consistency)
- Definition: Measures the semantic similarity and logical relationship between the top words grouped within a single topic or across an extended interaction. Common measures include UMass, UCI, and NPMI (Normalized Pointwise Mutual Information).
