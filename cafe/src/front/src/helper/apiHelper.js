const apiHelper = {
    post: async (URL, DATA) => {
        return await fetch(URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(DATA),
        }).then(response => response.json())
            .then(ret => {
                return ret;
            })
            .catch(e => {
                console.error(e);
                return {'message': e};
            });
    },
    postParallel: async (URLS, DATALIST) => {
        const requests = [];
        DATALIST.forEach((DATA, index) => {
           console.log('index : ', index);
            requests.push(
                fetch(URLS[index], {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json;charset=utf-8'
                    },
                    body: JSON.stringify(DATA)
                })
                .then(response => {
                    if(response.ok) {
                        return response.json();
                    }
                    return Promise.reject(response.statusText);
                })
                .catch(e => {
                    console.error(e);
                    return {'message': e}
                })
            );
        });
        // 병렬 요청들의 모든 결과과 완료되기를 기다린 후 반환
        return Promise.all(requests);
    },
    get: async (URL) => {
        return await fetch(URL, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
        }).then(response => response.json())
            .then(ret => {
                return ret;
            })
            .catch(e => {
                console.error(e);
                return {'message': e};
            });
    },
    delete: async (URL) => {
        return await fetch(URL, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
        }).then(response => response.json())
            .then(ret => {
                return ret;
            })
            .catch(e => {
                console.error(e);
                return {'message': e};
            });
    },
    put: async (URL, DATA) => {
        return await fetch(URL, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(DATA),
        }).then(response => response.json())
            .then(ret => {
                return ret;
            })
            .catch(e => {
                console.error(e);
                return {'message': e};
            });
    }
}

export default apiHelper;
