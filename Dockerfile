FROM python:3.8
WORKDIR /app
COPY . /app
RUN pip install requests
CMD ["python3", "tst.py"]
