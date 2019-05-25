# A very simple Flask Hello World app for you to get started with...
import requests
from flask import Flask, jsonify
from flask import request
import MySQLdb
import sys
import json

app = Flask(__name__)

#host = 'LucaTedeschini2000.mysql.pythonanywhere-services.com'
#c=MySQLdb.connect(host=host,user='LucaTedeschini20',passwd='parlotroppo',db='LucaTedeschini20$default')
#cursor = c.cursor()
#cursor.execute("select * from Utenti;")
#rows=cursor.fetchall()
#print(rows[0])
#c.commit()
#c.close()



@app.route('/API/Login', methods=['POST'])
def Login():
    try:
        log=request.get_json(force=True)
        email = str(log['email'])
        pw = str(log['password'])
        host = 'LucaTedeschini2000.mysql.pythonanywhere-services.com'
        c=MySQLdb.connect(host=host,user='LucaTedeschini20',passwd='parlotroppo',db='LucaTedeschini20$default')
        cursor=c.cursor()
        cursor.execute("SELECT email,password FROM Utenti WHERE email='"+email+"';")
        rows=cursor.fetchall()
        c.commit()
        c.close()

        if (rows[0][1] == pw):
            return jsonify({'status':'loggato'})
        else:
            return jsonify({'status':'nonloggato'})
    except:
        c.commit()
        c.close()
        return jsonify({'sta':str(sys.exc_info()[0])})
