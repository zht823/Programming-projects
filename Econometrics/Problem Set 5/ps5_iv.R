rm(list=ls())
setwd("/Users/haotianzhang/Desktop")

library(AER)
library(wooldridge)
library(lmtest)
library(sandwich)

##QUESTION 1
PS5data1=read.csv("ps5_iv.csv")

#m0 = lm(logpgp95~avexpr, data=PS5data1)
#coeftest(m0, vcov=vcovHC(m1, type="HC1"))

#b) Asssess instrument relevance
m1 = lm(avexpr ~ logem4, data=PS5data1)
linearHypothesis(m1, c("logem4"), vcov=vcovHC(m1, type="HC1") )
##F-stat>10(Rule of Thumb) --> Not a weak instrument

#c) IV estimate
m2 = ivreg(logpgp95 ~ avexpr + lat_abst | logem4 + lat_abst , data=PS5data1)
coeftest(m2, vcov=vcovHC(m2, type="HC1"))

#d) Assess instrument validity
  # Check Relevance
m3 = lm(avexpr ~ logem4 + lat_abst, data=PS5data1)
linearHypothesis(m3, c("logem4"), vcov=vcovHC(m3, type="HC1") )
  # Check exogenous: Not over-identified, justify on logical or substantive grounds.

#e) J-test to test instrument validity
m4 = ivreg(logpgp95 ~ avexpr + lat_abst | logem4 + euro1900 + lat_abst , data=PS5data1)
PS5data1$uhat = PS5data1$logpgp95 - predict(m4) #Back out residuals
jReg = lm(uhat ~ logem4 + euro1900 , data=PS5data1)
jlh = linearHypothesis(jReg, c("logem4","euro1900"), vcov=vcovHC(jReg, type="HC1"))
Jstat = jlh$F[2] * 2   #J-stat = 24.4
#Reject, Instruments are not exogenous

#check relevance
m5 = lm(avexpr ~ logem4 + euro1900 + lat_abst, data=PS5data1)
linearHypothesis(m5, c("logem4","euro1900"), vcov=vcovHC(m5, type="HC1") )


##QUESTION 2
library(rddtools)
PS5data2=read.csv("ps5_rd.csv")

#a)
PS5data2$T = as.numeric(PS5data2$x>0)
PS5data2$inter = PS5data2$x * PS5data2$T
linear_0 <- lm(averageclasssize ~ T + x + inter, data = subset(PS5data2, x >= -10 & x <= 10))
coeftest(linear_0, vcov=vcovHC(linear_0, type="HC1"))

#b)
linear_1 <- lm(averageclasssize ~ T + x + inter + enroll + pctblack + pctwhite + pcthisp + pctdisability + pctEL, data = subset(PS5data2, x >= -10 & x <= 10))
coeftest(linear_1, vcov=vcovHC(linear_1, type="HC1"))
linear_2 <- lm(mathscore ~ T + x + inter + enroll + pctblack + pctwhite + pcthisp + pctdisability + pctEL, data = subset(PS5data2, x >= -10 & x <= 10))
coeftest(linear_2, vcov=vcovHC(linear_2, type="HC1"))

#c)
regc1 <- lm(enroll ~ T * x, data=subset(PS5data2, x >= -10 & x <= 10))
coeftest(regc1, vcov=vcovHC(regc1, type="HC1"))
#Not significant

regc2 <- lm(pctblack ~ T * x, data=subset(PS5data2, x >= -10 & x <= 10))
coeftest(regc2, vcov=vcovHC(regc2, type="HC1"))
#Not significant

regc3 <- lm(pctwhite ~ T * x, data=subset(PS5data2, x >= -10 & x <= 10))
coeftest(regc3, vcov=vcovHC(regc3, type="HC1"))
#Not significant

regc4 <- lm(pcthisp ~ T * x, data=subset(PS5data2, x >= -10 & x <= 10))
coeftest(regc4, vcov=vcovHC(regc4, type="HC1"))
#Not significant

regc5 <- lm(pctdisability ~ T * x, data=subset(PS5data2, x >= -10 & x <= 10))
coeftest(regc5, vcov=vcovHC(regc5, type="HC1"))
#Not significant

regc6 <- lm(pctEL ~ T * x, data=subset(PS5data2, x >= -10 & x <= 10))
coeftest(regc6, vcov=vcovHC(regc6, type="HC1"))
#Not significant

hist(PS5data2$x)