import csv
from datetime import datetime
import json
import numpy as np
import requests

def Gw2V2Api(api):
    return 'https://api.guildwars2.com/v2/' + api

def Post(url, data, headers={'User-Agent': 'Fake User Agent'}):
    print(url)
    with requests.Session() as session:
        session.headers.update(headers)
        return session.post(url, data).text

def Get(url, headers={'User-Agent': 'Fake User Agent'}):
    print(url)
    with requests.Session() as session:
        session.headers.update(headers)
        return session.get(url).text

def Csv(csv_file_name, profitable, header, write_header=False):
    with open(csv_file_name, 'a') as f:
        writer = csv.DictWriter(f, header)
        if write_header:
            writer.writeheader()
        for entry in profitable:   
            writer.writerow(entry)

def AllTpListedIds():
    return json.loads(Get(Gw2V2Api('commerce/listings')))

def TpList(ids):
    return json.loads(Get(Gw2V2Api('commerce/listings?ids=' +
                                      ','.join(str(id) for id in ids))))

def Item(id):
    return json.loads(Get(Gw2V2Api('items/' + str(id))))

def IsProfitable(sell, buy):
    return (sell - 1) > (buy + 1) * 1.15

def CalProfit(sell, buy):
    return (sell - buy - 2) / buy


id_tuples = np.array_split(np.array(AllTpListedIds()),1000)
csv_file_name = 'tp_profitable_' + datetime.now().strftime('%Y-%m-%dT%H:%M:%SZ') + '.csv'
csv_header = ('id', 'name', 'type', 'profit', 'sell_listings',
            'sell_price', 'sell_qty', 'buy_listings', 'buy_price',
            'buy_qty')
Csv(csv_file_name, (), csv_header, True)

for ids in id_tuples:
    listings = TpList(ids.tolist())
    profitable = []
    for listing in listings:
        if listing['buys'] and listing['sells']:
            sell = listing['sells'][0]
            buy = listing['buys'][0]
            if IsProfitable(sell['unit_price'], buy['unit_price']):
                item = Item(listing['id'])
                try:
                    profitable.append({
                        'id': listing['id'],
                        'name': item['name'],
                        'type': item['type'],
                        'profit': CalProfit(sell['unit_price'], buy['unit_price']),
                        'sell_listings': sell['listings'],
                        'sell_price': sell['unit_price'],
                        'sell_qty': sell['quantity'],
                        'buy_listings': buy['listings'],
                        'buy_price': buy['unit_price'],
                        'buy_qty': buy['quantity']
                    })
                except:
                    print(item)
    Csv(csv_file_name, profitable, csv_header)

