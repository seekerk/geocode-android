package org.fruct.oss.geopoint;

import org.fruct.oss.geopoint.base.BaseRDF;
import org.fruct.oss.geopoint.base.SIBFactory;

import java.util.ArrayList;
import java.util.Iterator;
import sofia_kp.KPICore;
import sofia_kp.SIBResponse;

/**
 * null
 */
public class GeoPoint extends BaseRDF {

    private static final String CLASS_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#GeoPoint";

    /**
     * Creates new class entity
     * @param objectID class entity id
     * @param accessPointName the name of used access point
     */
    public GeoPoint(String objectID, String accessPointName) {
        super(objectID, accessPointName);
    }

    /**
     * Creates new class entity
     * @param accessPointName  the name of used access point
     */
    public GeoPoint(String accessPointName) {
        super(generateID("GeoPoint"), accessPointName);
    }

    public GeoPoint() {
        super(generateID("GeoPoint"), SIBFactory.getInstance().getDefaultAccessPointName());
    }

    //------------ isWest --------------
        private static final String isWest_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#isWest";
        private ArrayList<Double> _isWest_new = null;

        public ArrayList<Double> isWest() {
            if (_isWest_new != null) {
                return _isWest_new;
            }
            // search in triple store
            return getDoubleInTriples(isWest_URI);
        }

        public void isWest(Double value) {
            isWest(value, true);
        }

        public void isWest(ArrayList<Double> value) {
            isWest(value, true);
        }

        public void isWest(Double value, boolean removeOldValues) {
             if (_isWest_new == null) {
                _isWest_new = isWest();
            }
            if (removeOldValues) {
                _isWest_new.clear();
            }
            _isWest_new.add(value);
        }

        public void isWest(ArrayList<Double> value, boolean removeOldValues) {
            if (_isWest_new == null) {
                _isWest_new = isWest();
            }
            if (removeOldValues) {
                _isWest_new.clear();
            }
            _isWest_new.addAll(value);
        }
    //============== isWest =============
    //------------ isNorth --------------
        private static final String isNorth_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#isNorth";
        private ArrayList<Double> _isNorth_new = null;

        public ArrayList<Double> isNorth() {
            if (_isNorth_new != null) {
                return _isNorth_new;
            }
            // search in triple store
            return getDoubleInTriples(isNorth_URI);
        }

        public void isNorth(Double value) {
            isNorth(value, true);
        }

        public void isNorth(ArrayList<Double> value) {
            isNorth(value, true);
        }

        public void isNorth(Double value, boolean removeOldValues) {
             if (_isNorth_new == null) {
                _isNorth_new = isNorth();
            }
            if (removeOldValues) {
                _isNorth_new.clear();
            }
            _isNorth_new.add(value);
        }

        public void isNorth(ArrayList<Double> value, boolean removeOldValues) {
            if (_isNorth_new == null) {
                _isNorth_new = isNorth();
            }
            if (removeOldValues) {
                _isNorth_new.clear();
            }
            _isNorth_new.addAll(value);
        }
    //============== isNorth =============
    //------------ hasLongitude --------------
        private static final String hasLongitude_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#hasLongitude";
        private ArrayList<Double> _hasLongitude_new = null;

        public ArrayList<Double> hasLongitude() {
            if (_hasLongitude_new != null) {
                return _hasLongitude_new;
            }
            // search in triple store
            return getDoubleInTriples(hasLongitude_URI);
        }

        public void hasLongitude(Double value) {
            hasLongitude(value, true);
        }

        public void hasLongitude(ArrayList<Double> value) {
            hasLongitude(value, true);
        }

        public void hasLongitude(Double value, boolean removeOldValues) {
             if (_hasLongitude_new == null) {
                _hasLongitude_new = hasLongitude();
            }
            if (removeOldValues) {
                _hasLongitude_new.clear();
            }
            _hasLongitude_new.add(value);
        }

        public void hasLongitude(ArrayList<Double> value, boolean removeOldValues) {
            if (_hasLongitude_new == null) {
                _hasLongitude_new = hasLongitude();
            }
            if (removeOldValues) {
                _hasLongitude_new.clear();
            }
            _hasLongitude_new.addAll(value);
        }
    //============== hasLongitude =============
    //------------ hasLatitude --------------
        private static final String hasLatitude_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#hasLatitude";
        private ArrayList<Double> _hasLatitude_new = null;

        public ArrayList<Double> hasLatitude() {
            if (_hasLatitude_new != null) {
                return _hasLatitude_new;
            }
            // search in triple store
            return getDoubleInTriples(hasLatitude_URI);
        }

        public void hasLatitude(Double value) {
            hasLatitude(value, true);
        }

        public void hasLatitude(ArrayList<Double> value) {
            hasLatitude(value, true);
        }

        public void hasLatitude(Double value, boolean removeOldValues) {
             if (_hasLatitude_new == null) {
                _hasLatitude_new = hasLatitude();
            }
            if (removeOldValues) {
                _hasLatitude_new.clear();
            }
            _hasLatitude_new.add(value);
        }

        public void hasLatitude(ArrayList<Double> value, boolean removeOldValues) {
            if (_hasLatitude_new == null) {
                _hasLatitude_new = hasLatitude();
            }
            if (removeOldValues) {
                _hasLatitude_new.clear();
            }
            _hasLatitude_new.addAll(value);
        }
    //============== hasLatitude =============


    public void update() {
        // update triple store
        load();

        // триплеты для добавления
        ArrayList<ArrayList<String>> newTriples = new ArrayList();

        // триплеты для удаления
        ArrayList<ArrayList<String>> removeTriples = new ArrayList();

        // 1. проверяем, новый ли индивид. Если новый, то у него нет триплетов с сиба
        if (getStringInTriples(RDF_TYPE_URI).isEmpty()) {
            // Добавляем триплет для класса индивида
            newTriples.add(createTriple(getID(), RDF_TYPE_URI, getURI()));
        }

                if (_isWest_new != null) {
                    // получаем старые значения
                    ArrayList<Double> oldVals = getDoubleInTriples(isWest_URI);
                    Iterator<Double> itrNew = _isWest_new.iterator();
                    while (itrNew.hasNext()) {
                        Double curNew = itrNew.next();
                        // ищем старое значение
                        Iterator<Double> itrOld = oldVals.iterator();
                        while(itrOld.hasNext()) {
                            Double curOld = itrOld.next();
                            if (curNew.equals(curOld)) {
                                itrNew.remove();
                                itrOld.remove();
                                break;
                            }
                        }
                    }
                    for(Double val : _isWest_new) {
                        newTriples.add(createTriple(getID(), isWest_URI, val.toString(), "uri", "literal"));
                    }
                    for(Double val : oldVals){
                        removeTriples.add(createTriple(getID(), isWest_URI, val.toString(), "uri", "literal"));
                    }
        	    _isWest_new = null;
                }
        //-----------------------
                if (_isNorth_new != null) {
                    // получаем старые значения
                    ArrayList<Double> oldVals = getDoubleInTriples(isNorth_URI);
                    Iterator<Double> itrNew = _isNorth_new.iterator();
                    while (itrNew.hasNext()) {
                        Double curNew = itrNew.next();
                        // ищем старое значение
                        Iterator<Double> itrOld = oldVals.iterator();
                        while(itrOld.hasNext()) {
                            Double curOld = itrOld.next();
                            if (curNew.equals(curOld)) {
                                itrNew.remove();
                                itrOld.remove();
                                break;
                            }
                        }
                    }
                    for(Double val : _isNorth_new) {
                        newTriples.add(createTriple(getID(), isNorth_URI, val.toString(), "uri", "literal"));
                    }
                    for(Double val : oldVals){
                        removeTriples.add(createTriple(getID(), isNorth_URI, val.toString(), "uri", "literal"));
                    }
        	    _isNorth_new = null;
                }
        //-----------------------
                if (_hasLongitude_new != null) {
                    // получаем старые значения
                    ArrayList<Double> oldVals = getDoubleInTriples(hasLongitude_URI);
                    Iterator<Double> itrNew = _hasLongitude_new.iterator();
                    while (itrNew.hasNext()) {
                        Double curNew = itrNew.next();
                        // ищем старое значение
                        Iterator<Double> itrOld = oldVals.iterator();
                        while(itrOld.hasNext()) {
                            Double curOld = itrOld.next();
                            if (curNew.equals(curOld)) {
                                itrNew.remove();
                                itrOld.remove();
                                break;
                            }
                        }
                    }
                    for(Double val : _hasLongitude_new) {
                        newTriples.add(createTriple(getID(), hasLongitude_URI, val.toString(), "uri", "literal"));
                    }
                    for(Double val : oldVals){
                        removeTriples.add(createTriple(getID(), hasLongitude_URI, val.toString(), "uri", "literal"));
                    }
        	    _hasLongitude_new = null;
                }
        //-----------------------
                if (_hasLatitude_new != null) {
                    // получаем старые значения
                    ArrayList<Double> oldVals = getDoubleInTriples(hasLatitude_URI);
                    Iterator<Double> itrNew = _hasLatitude_new.iterator();
                    while (itrNew.hasNext()) {
                        Double curNew = itrNew.next();
                        // ищем старое значение
                        Iterator<Double> itrOld = oldVals.iterator();
                        while(itrOld.hasNext()) {
                            Double curOld = itrOld.next();
                            if (curNew.equals(curOld)) {
                                itrNew.remove();
                                itrOld.remove();
                                break;
                            }
                        }
                    }
                    for(Double val : _hasLatitude_new) {
                        newTriples.add(createTriple(getID(), hasLatitude_URI, val.toString(), "uri", "literal"));
                    }
                    for(Double val : oldVals){
                        removeTriples.add(createTriple(getID(), hasLatitude_URI, val.toString(), "uri", "literal"));
                    }
        	    _hasLatitude_new = null;
                }
        //-----------------------


        SIBResponse ret;
        ret = SIBFactory.getInstance().getAccessPoint(_accessPointName).insert(newTriples);
        if (!ret.isConfirmed()) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        ret = SIBFactory.getInstance().getAccessPoint(_accessPointName).remove(removeTriples);
        if (!ret.isConfirmed()) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public String getURI() {
        return CLASS_URI;
    }

    @Override
    public void removeProperty(String URI) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}