
# coding: utf-8

# # Programming Assignment 1
# # MATH-UA 250 Mathematics of Finance
# # Portfolio Management

# In[1]:

import sys
sys.version
sys.version_info


# 
# # Useful Python code
# 
# https://pandas.pydata.org/pandas-docs/stable/10min.html
# https://pandas.pydata.org/pandas-docs/stable/visualization.html
# 

# In[2]:

get_ipython().magic(u'matplotlib inline')

import matplotlib
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd


# #  File Contents
# Returns to the following asset classes are contained in the file
#  * "MSCI WORLD"
#  * "MSCI AC WORLD"    
#  * "MSCI EUROPE"
#  * "MSCI EM"
#  * "MSCI EAFE"        
#  * "MSCI PACIFIC"
#  * "MSCI USA"
#  * "Treasury.Bond.10Y"
#  * "Treasury.Bill.90D"
# 
# 
#  <span style="color:blue">Our set of risky assets for the analysis is  MSCI EUROPE, MSCI USA , MSCI PACIFIC, Treasury.Bond.10Y </span>
# 

# In[5]:

#
# read in the data

inpath  = "/Users/josephcerniglia/Dropbox/NYU/MathFin/code_R/"
outpath = "/Users/josephcerniglia/Dropbox/NYU/MathFin/code_R/"

infile  = "ReturnsPortfolios.csv"

print(inpath+infile)
indata = pd.read_csv( inpath + infile)


# In[4]:

indata.head(5)


# In[44]:

RiskyAsset     = ["MSCI EUROPE","MSCI USA","MSCI PACIFIC","Treasury.Bond.10Y"]
RiskFreeAsset  = "Treasury.Bill.90D"


# In[45]:

# 
# print out forst 3 rows and all columns of risky assets
indata.loc[1:3,RiskyAsset]


# 
# ## <span style="color:blue">Part 1: Risky Assets Analysis</span>
# 
#  Create a table calculating a-h for the risky assets:
# 1. mean
# 2.	median
# 3.	standard deviations 
# 4.	skew 
# 5.	kurtosis
# 6.  return - risk ratio 
# 7.  plot the assets classes on a return - risk graph   
# 8.  Write up a paragraph comparing the statistics of the risky assets
# 

# In[46]:

indata[RiskyAsset].mean()


# 
# ## <span style="color:blue">Part 2:  Distributions </span>
# Plot the distributions for each asset class
# 
# Compare the distribution

# In[47]:

indata["MSCI EUROPE"].plot.hist(stacked=True, bins=20)


# ## <span style="color:blue"> Part 3: Covariance and Correlation Matrices  </span>
# 
#  1.	Calculate the covariance matrix 
#  2. Calculate the correlation matrix
#  3.	Verify the covariance matrix is non-singular
#  4.	Verify the covariance matrix is symmetric and positive definite
# 

# ## <span style="color:blue">Part 4: Calculate the weights, returns and risks for the following portfolios     </span>
#  1.	Minimum variance portfolio
#  2. Portfolio with expected return of 9% and minimum variance
#  3. Efficicent frontier (calculate the weights, returns and risk of at least 7 portfolios)
#  4. Plot the portfolios and asset classes on a graph
#  5. Plot an equal weighted portolio on the graph
#  6. What is the expected return and risk of the minimum variance portfolio
#   

# ## <span style="color:blue">Part 5: Calculate the beta (t-stat, R-square) of each the risk asset class to the following 2 'market' portfolios   </span>
# 
#   Market Portfolio 1: "MSCI AC WORLD"    
#   Market Portfolio 2: "MSCI USA"
#   
#   Compare the betas for each asset class
# 

# ## <span style="color:blue">Part 6: Extra Credit </span>
# 
# Exponentially Weighted Moving Average Covariance Matrix
# An exponentially weighted moving average (EWMA) puts more weight on the more recent observations, and thus takes some account of the dynamic ordering in returns.  When an EWMA is applied to squared returns the resulting volatility estimate will react immediately following an unusually large return.  Then the effect of this return in the EWMA gradually diminishes over time.  The reaction of EWMA volatility estimates to market events therefore persist over time, and with a strength determined by the smoothing constant \lambda.  This is a number between 0 and 1.  The larger the value of \lambda the more weight is placed on past observations and so the smoother the series becomes.  (Alexander, 2001)
# 
# Look up how to calculate a covariance matrix using EWMA
# Calculate the 4 minimum variance portfolio with this matrix using 4 different \lambdas.  Compare the weights for these 4 different \lambdas and the equal weighted (normal covariance matrix from Part 3)
# 
