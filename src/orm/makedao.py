#-*- coding: utf-8 -*-

import os
import sys
import time

INDENT = "    "

def emitir_getter(classe, tabela, tipo, nome):
    print "public static List<%s> por%s(%s %s)" \
          % (classe,
             nome.replace("_", " ").title().replace(" ", ""),
             tipo,
             nome)

    print "{"
    corpo = ("Session s = HibernateUtil.getSessionFactory().getCurrentSession();",
           "s.beginTransaction();",
           'Query q = s.createQuery("from %s where %s=?");' % (tabela, nome),
           'List l = q.setString(0, String.format("%%s", %s)).list();' % nome,
           "List<%s> ret = new ArrayList<%s>(l.size());" % (classe, classe),
           "for (Object o : l) ret.add((%s) o);" % classe,
           "s.getTransaction().commit();",
           "return ret;")

    for linha in corpo:
        print INDENT + linha

    print "}"
    print

def emitir_salvar():
    print "public void salvar()"
    print "{"

    corpo = ("Session s = HibernateUtil.getSessionFactory().getCurrentSession();",
             "s.beginTransaction();",
             "s.save(this);",
             "s.getTransaction().commit();")

    for linha in corpo:
        print INDENT + linha

    print "}"
    print

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print >>sys.stderr, "Uso: %s <arquivo>.dao" % sys.argv[0]
        sys.exit(1)

    classe, _ = os.path.splitext(sys.argv[1])

    print "// Começo do código autogerado"
    print "// " + time.asctime()

    with open(sys.argv[1], "r") as config:
        tabela = config.readline().strip()
        campos = map(str.split, config)

    for tipo, nome in campos:
        emitir_getter(classe, tabela, tipo, nome)

    emitir_salvar()
    print "// Fim do código autogerado"
