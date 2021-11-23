import pandas as pd                        
from pytrends.request import TrendReq

pytrend = TrendReq()
df = pytrend.trending_searches(pn='brazil')

out = ""

for elem in df[0]:
  out += ("" if out == "" else ", ") + elem

print(out)