const path = require('path');
const SRC_DIR = path.join(__dirname, '/react-client/src');
const DIST_DIR = path.join(__dirname, '/react-client/dist');
const webpack = require('webpack');
module.exports = {
    entry: `${SRC_DIR}/index.js`,
    output: {
        path: DIST_DIR,
        filename: 'bundle.js',
    },
    module : {
        rules : [
            {
                test: /\.css$/,
                loader: 'style-loader!css-loader'
            },
            {
                test: /\.png$/,
                loader: 'url-loader?limit=100000&minetype=image/png'
            },
            {
                test: /\.jpg/,
                loader: 'file-loader'
            },
            {
                test: /\.(js|jsx)$/,
                include : SRC_DIR,
                exclude : /node_modules/,
                loader : 'babel-loader',
                query: {
                    presets: ['react', 'es2015']
                }
            }
        ]
    },
    "presets": [["env", {"modules": true}], "react"],
    "env": {
        "test": {
            "presets": [["env"], "react"]
        }
    },
    plugins: [
        new webpack.DefinePlugin({
            'process.env.NODE_ENV': JSON.stringify('production')
        })
    ]
};