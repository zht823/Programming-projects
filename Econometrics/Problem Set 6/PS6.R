rm(list=ls())
setwd("/Users/haotianzhang/Desktop")
library(AER)
library(lmtest)
library(sandwich)
library(zoo)
library(dynlm)

PS6data=read.csv("cpi_unemp.csv")

cpi_ts = ts(PS6data, start=c(1948,1), frequency=12)
inf <- diff(log(cpi_ts))*12

##Practical Question
#a)
ar1 = dynlm(data=inf, cpi~L(cpi,1:1), start=1974 + 0/12, end=2011 + 0/12)
summary(ar1)
coef(ar1)

ar3 = dynlm(data=inf, cpi~L(cpi,1:3), start=1974 + 0/12, end=2011 + 0/12)
summary(ar3)
coef(ar3)

ar6 = dynlm(data=inf, cpi~L(cpi,1:6), start=1974 + 0/12, end=2011 + 0/12)
summary(ar6)
coef(ar6)

#b)
pred_ar1 = coef(ar1)[1] + 0.0476462968*coef(ar1)[2]
pred_ar3 = coef(ar3)[1] + 0.0476462968*coef(ar3)[2] + 0.0516674320*coef(ar3)[3] + 0.0147876678*coef(ar3)[4] 
pred_ar6 = coef(ar6)[1] + 0.0476462968*coef(ar6)[2] + 0.0516674320*coef(ar6)[3] + 0.0147876678*coef(ar6)[4] + 0.0297944142*coef(ar6)[5] + 0.0197395462*coef(ar6)[6] + 0.0246225814*coef(ar6)[7]

#c)
actual = 0.0653962694
actual - pred_ar1 
actual - pred_ar3 
actual - pred_ar6 

#d)
library(fUnitRoots)
adfTest(PS6data$unrate, lags = 1, type = "c")
#reject H0