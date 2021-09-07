
let _requestAnimationFrameGlobalCallBack;
const window = this;

_globalGL.texImage2D = (...args)=>{
    if (args.length===9) {
        _globalGL.texImage2D_9(...args);
    }
    else if (args.length===6) _globalGL.texImage2D_6(...args);
    else throw new Error('wrong arguments for texImage2D invocation');
}

(()=>{

    window.requestAnimationFrame = (fn)=>{
        if (_requestAnimationFrameGlobalCallBack===undefined) _requestAnimationFrameGlobalCallBack = fn;
    };

    class CanvasStyle {

        constructor(){
            this._width = undefined;
            this._height = undefined;
        }

        set width(val){
            this._width = val;
            _surfaceResizer.setWidth(parseInt(val));
        }

        get width(){
            return this._width;
        }

        set height(val){
            this._height = val;
            _surfaceResizer.setHeight(parseInt(val));
        }

        get height(){
            return this._height;
        }
    }

    class Canvas {
        constructor(){
            this.width = innerWidth;
            this.height = innerHeight;
            this.style = new CanvasStyle();
            this.ontouchstart = ()=>{};
            this.ontouchmove = ()=>{};
            this.ontouchend = ()=>{};
        }
        getContext(val){
            return _globalGL;
        }
        setAttribute(){
        }
        addEventListener(){
        }
    }

    window._globalCanvas = new Canvas();

    class Document {
        constructor(){
            this.canvas = window._globalCanvas;
            this.body = {
                appendChild:()=>{},
                style: {}
            }
        }
        createElement(val){
            if (val==='canvas') return window._globalCanvas;
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
            this.onerror = null;
            this._buffer = null;
            this.width = 0;
            this.height = 0;
        }

        _loadData(){
            _eventQueue.executeOnNextTask(()=>{
                _files.loadAssetAsImage(
                    this._src,
                    (imgData)=>{
                        this.id = imgData.id;
                        this.width = imgData.width;
                        this.height = imgData.height;
                        this._onload();
                    },
                    this.onerror
                );
            });
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
        }

        get onload(){
            return this._onload;
        }

    }

    class Audio {
        constructor(){
            this._src = null;
            this._id = _audioFactory.createAudio(this);
            this._loop = false;
            this.onended = null;
        }
        set src(val){
            this._src = val;
        }
        get src(){
            return this._src;
        }
        set loop(val){
            _audioFactory.setLoop(this._id,val);
            this._loop = val;
        }
        get loop(){
            return this._loop;
        }
        play(){
             _audioFactory.play(this._id,this._src);
        }
        stop(){
             _audioFactory.stop(this._id);
        }
        pause(){
             _audioFactory.pause(this._id);
        }
        canPlayType(type){
            return true;
        }

    }


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
            const successCallback = (resp)=>{
                this.readyState = 4;
                this.status = 200;
                this.response = resp;
                if (resp && resp.toUpperCase) this.responseText = resp;
                this.onload && this.onload();
                this.onreadystatechange && this.onreadystatechange();
            };
            const errorCallback = (e)=>{
                console.error(e);
            };
            (this.responseType==='blob' || this.responseType==='arraybuffer')?
                _files.loadAssetAsBinary(currUrl,successCallback,errorCallback):
                _files.loadAssetAsString(currUrl,successCallback,errorCallback);

        }

        getResponseHeader(){

        }

    };

    window.XMLHttpRequest = XMLHttpRequest;
    window.Image = Image;
    window.document = new Document();
    window.Audio = Audio;
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
    window._triggerEvent = (name,arg)=>{
        events.forEach(it=>{
            if (it.name===name) it.cb(arg);
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




