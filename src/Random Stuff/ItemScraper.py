import requests
from bs4 import BeautifulSoup
import csv

# Make a GET request to the URL
url = 'https://roll20.net/compendium/dnd5e/Index%3AItems'
response = requests.get(url)

# Parse the HTML content of the page
soup = BeautifulSoup(response.content, 'html.parser')

# Find all the items on the page
items = soup.find_all('li')

# Create a list to store the data
data = []
item_data = {}
# Loop through each item
for item in items:
  # Extract the item name and href
  item_name = item.find('a')
  #filter out unwanted items
  if item_name.get('href') and 'https' not in item_name.get(
      'href') and 'http' not in item_name.get('href'):
    item_data[item_name.text.strip(" ")] = item_name.get('href')

print(len(item_data.keys()))
#print(item_data['Abacus'])
count = 0
#Make one request per item to get attributes
for key in item_data.keys():
  print(key)
  url1 = "https://roll20.net"+item_data[key]
  resp1 = requests.get(url1)
  soup1 = BeautifulSoup(resp1.content, 'html.parser')
  attributes = soup1.find_all("div", {"class": "row attrListItem"})
  AttributesDict = {}
  for attribute in attributes:
    name = attribute.find('div',{'class':'col-md-3 attrName'}).text
    value = attribute.find('div',{'class':'value'}).text
    AttributesDict[name] = value
  item_data[key]= AttributesDict

  
for key in item_data.keys():
  print(item_data[key]['Item Type'])




