# RegistryPoints
World Swing Dance Council Points Registry Android SDK

## Usage

Search for dancers (to obtain wscid)
```
PointsManager.getInstance().search("Kara", new PointsCallback<List<DancerName>>() {
            @Override
            public void success(List<DancerName> data) {
                Toast.makeText(MainActivity.this, data.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void error(Throwable error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
```

Get a dancer's competitions
```
PointsManager.getInstance().getDancer(6284, new PointsCallback<Dancer>() {
            @Override
            public void success(Dancer data) {
                Toast.makeText(DancerDetailsActivity.this, "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void error(Throwable error) {
                Toast.makeText(DancerDetailsActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
```
