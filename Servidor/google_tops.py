from pytrends.request import TrendReq

pytrend = TrendReq()
df = pytrend.trending_searches(pn='brazil')

out = ""
i = 0
for elem in df[0]:
  i += 1
  out += ("" if out == "" else "^") + "%02d" % (i,) + " - " + elem

print(out)