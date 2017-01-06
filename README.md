# EAN_code_search
This is a test for EAN lookup.

EAN lookup

Most of the products have a 13 digit code - the EAN code. On the web, one can find databases that allow to search EAN codes for products and decode the EAN code into product name. I would like you to write a program, that will for a given file (a text file with one product name/description per line) will look up the EAN code in a given database. The heuristics should be that if the product is not found in one DB it will, as a fall back try in next DB (which is beyond the scope of this test though). So, take into consideration in your implementation that the set of DBs can be extended to a greater number later on so this extension should be thought of and easy to do later (in other words, the look up should not be hardcoded but rather be wrapped with internal API thus transparent to the program). Also, the lookup is an HTTP communication with latency, so in order to go through the list as fast as possible, please implement multithreaded lookups (using java's Future and thread pool).

As the DB please use the following site:
http://world.openfoodfacts.org/cgi/search.pl?search_terms=boursin&search_simple=1&action=process

with the API description:
http://en.wiki.openfoodfacts.org/Project:API

The output of this test should be a JSON containing key-value pairs with the original product name, the EAN code and the description of the associated product (found in the DB). In case theEAN is not found, add only the original product description in the output file.

The input file examples:
http://im04.internetmemory.org/data/problems/grocery.txt
