
let _requestAnimationFrameGlobalCallBack;
const window = this;

_globalGL.texImage2D = (...args)=>{
    if (args.length===9) _globalGL.texImage2D_9(...args);
    else if (args.length===6) _globalGL.texImage2D_6(...args);
    else throw new Error('wrong arguments for texImage2D invocation');
}

(()=>{

    window.requestAnimationFrame = (fn)=>{
        if (_requestAnimationFrameGlobalCallBack===undefined) _requestAnimationFrameGlobalCallBack = fn;
    };

    class Canvas {
        constructor(){
            this.width = innerWidth;
            this.height = innerHeight;
            this.style = {};
        }
        getContext(val){
            return _globalGL;
        }
        setAttribute(){
        }
        addEventListener(){
        }
    }

    class Document {
        constructor(){
            this.canvas = new Canvas();
            this.body = {
                appendChild:()=>{}
            }
        }
        createElement(val){
            if (val==='canvas') return new Canvas();
        }
        getElementById(val){
            return this.canvas;
        }
        querySelector(){
            return this.canvas;
        }
        addEventListener(){
        }
    }

    class Image {

        constructor(){
            this.id = null;
            this._src = null;
            this._onload = null;
            this._buffer = null;
            this.width = 0;
            this.height = 0;
        }

        _loadData(){
            if (this._src!==null && this._onload!==null) {
                var imgData = _files.loadAssetAsImage(this._src);
                this.id = imgData.id;
                this.width = imgData.width;
                this.height = imgData.height;
                this._onload();
            }
        }

        set src(val){
            this._src = val;
            this._loadData();
        }

        get src(){
            return this._src;
        }

        set onload(cb) {
            this._onload = cb;
            this._loadData();
        }

        get onload(){
            return this._onload;
        }

    }

    const readAsBin = (url)=>{
        try {
            return _files.loadAssetAsBinary(url);
        } catch (e) {
            console.error('readAsBin error: ' + url + " " + e);
            throw e;
        }
    };

    const readAsText = (url)=>{
        try {
            return _files.loadAssetAsString(url);
        } catch (e) {
            console.error('readAsText error: ' + url + " " + e);
            throw e;
        }
    };

    class XMLHttpRequest {

        constructor() {
            this.status = 0;
            this.url = '';
        }

        setRequestHeader(){

        }

        open(method,url){
            this.url = url;
        }

        send(){
            const currUrl = this.url.split('?')[0];
            const resp = (this.responseType==='blob' || this.responseType==='arraybuffer')?readAsBin(currUrl):readAsText(currUrl);
            this.readyState = 4;
            this.status = 200;
            this.response = resp;
            if (resp && resp.toUpperCase) this.responseText = resp;
            this.onload && this.onload();
            this.onreadystatechange && this.onreadystatechange();
        }

        getResponseHeader(){

        }

    };

    window.XMLHttpRequest = XMLHttpRequest;
    window.Image = Image;
    window.document = new Document();
    window.navigator = {
        platform: 'vEngine',
        userAgent: 'vEngine'
    };
    window.innerWidth = innerWidth;
    window.innerHeight = innerHeight;
    window.self = window;
    window.top = window;

    let events = [];
    window.addEventListener = (name,cb)=>{
        events.push({name:name,cb:cb});
    };
    window.removeEventListener = (name,cb)=>{
        events.splice(events.indexOf(it=>it.cb===cb),1);
    }
    window._triggerEvent = (name)=>{
        events.forEach(it=>{
            if (it.name===name) it.cb();
        });
    }

    window.performance = {
        now: ()=>new Date().getTime()
    }
    window.setTimeout = ()=>{};
    window.setInterval = ()=>{};

})();

//const glNameByName = {};
//Object.keys(_globalGL).forEach(key=>{
//    glNameByName[_globalGL[key]] = key;
//});
//
//Object.keys(_globalGL).forEach(key=>{
//    const orig = _globalGL[key];
//    if (typeof _globalGL[key]!=='function') return;
//    if (key==='getError') return;
//    _globalGL[key] = (...args)=>{
//        const result = orig(...args);
//        if (_globalGL.getError()!==0) {
//            const argsDebug = [];
//            args.forEach(arg=>{
//                argsDebug.push(glNameByName[arg]||arg);
//            });
//            throw new Error(`error invocation ${key} with args ${argsDebug} (${args})`);
//        }
//        return result;
//    }
//});




